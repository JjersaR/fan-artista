package com.rsj.sg.usu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rsj.sg.usu.entity.Usuario;
import com.rsj.sg.usu.repository.IUsuarioRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsImplService implements UserDetailsService {

  private final IUsuarioRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.debug("Buscando usuario {}", username);

    var user = repository.findByUsernameOrEmail(username).orElseThrow(() -> {
      log.warn("Usuario no encontrado con credencial: {}", username);
      return new UsernameNotFoundException("Usuario no encontrado: " + username);
    });

    // Verificar que el usuario esté habilitado
    if (!user.isEnabled()) {
      log.warn("Intento de login para usuario deshabilitado: {}", username);
      throw new DisabledException("La cuenta está deshabilitada");
    }

    // Verificar que la cuenta no esté bloqueada
    if (!user.isAccountNoLocked()) {
      log.warn("Intento de login para cuenta bloqueada: {}", username);
      throw new LockedException("La cuenta está bloqueada");
    }

    // Verificar que la cuenta no haya expirado
    if (!user.isAccountNoExpired()) {
      log.warn("Intento de login para cuenta expirada: {}", username);
      throw new AccountExpiredException("La cuenta ha expirado");
    }

    // Verificar que las credenciales no hayan expirado
    if (!user.isCredentialNoExpired()) {
      log.warn("Intento de login con credenciales expiradas: {}", username);
      throw new CredentialsExpiredException("Las credenciales han expirado");
    }

    List<GrantedAuthority> authorities = buildAuthorities(user);

    log.debug("Usuario encontrado: {}, authorities: {}", user.getUsername(), authorities);

    return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNoExpired(),
        user.isCredentialNoExpired(), user.isAccountNoLocked(), authorities);
  }

  private List<GrantedAuthority> buildAuthorities(Usuario user) {
    List<GrantedAuthority> authorities = new ArrayList<>();

    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getTipoUsuario().name()));

    switch (user.getTipoUsuario()) {
      case ADMIN:
        authorities.add(new SimpleGrantedAuthority("CREATE_ARTIST"));
        authorities.add(new SimpleGrantedAuthority("DELETE_CONTENT"));
        authorities.add(new SimpleGrantedAuthority("VIEW_ALL_STATS"));
        break;
      case ARTISTA:
        authorities.add(new SimpleGrantedAuthority("UPLOAD_CONTENT"));
        authorities.add(new SimpleGrantedAuthority("VIEW_OWN_STATS"));
        authorities.add(new SimpleGrantedAuthority("MANAGE_MERCH"));
        break;
      case LISTENER:
        authorities.add(new SimpleGrantedAuthority("STREAM_MUSIC"));
        authorities.add(new SimpleGrantedAuthority("CREATE_PLAYLIST"));
        authorities.add(new SimpleGrantedAuthority("BUY_MERCH"));
        break;
    }

    return authorities;
  }
}
