package com.programacion4.unidad4ej5.feature.socio;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioUpdateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Transactional
    public SocioResponseDTO crearSocio(@Valid SocioCreateDTO dto) {
        if (socioRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }
        if (socioRepository.existsByDni(dto.getDni())) {
            throw new IllegalArgumentException("El DNI ya está registrado");
        }
        Socio socio = new Socio();
        socio.setNombre(dto.getNombre());
        socio.setApellido(dto.getApellido());
        socio.setEmail(dto.getEmail());
        socio.setDni(dto.getDni());
        socio.setFechaNacimiento(dto.getFechaNacimiento());
        socio.setTelefono(dto.getTelefono());
        socio = socioRepository.save(socio);
        return mapToResponse(socio);
    }

    @Transactional
    public SocioResponseDTO actualizarSocio(@Valid SocioUpdateDTO dto) {
        Socio socio = socioRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Socio no encontrado"));
        if (dto.getUrlFoto() != null) socio.setUrlFoto(dto.getUrlFoto());
        if (dto.getAlias() != null) socio.setAlias(dto.getAlias());
        socio = socioRepository.save(socio);
        return mapToResponse(socio);
    }

    public List<SocioResponseDTO> listarSocios() {
        return socioRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public Optional<SocioResponseDTO> obtenerSocio(Long id) {
        return socioRepository.findById(id).map(this::mapToResponse);
    }

    private SocioResponseDTO mapToResponse(Socio socio) {
        return new SocioResponseDTO(
                socio.getId(),
                socio.getNombre(),
                socio.getApellido(),
                socio.getEmail(),
                socio.getDni(),
                socio.getFechaNacimiento(),
                socio.getTelefono(),
                socio.getUrlFoto(),
                socio.getAlias()
        );
    }
}