package com.dashboard.crud_iot.dto;

import com.dashboard.crud_iot.enums.DeviceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para criação de um novo dispositivo IoT.
 * Contém apenas os campos necessários para criar um dispositivo.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceCreateDTO {
    
    @NotBlank(message = "Nome do dispositivo é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String deviceName;
    
    @NotBlank(message = "Identificador do dispositivo é obrigatório")
    @Size(max = 50, message = "Identificador deve ter no máximo 50 caracteres")
    private String deviceIdentifier;
    
    @NotNull(message = "Tipo do dispositivo é obrigatório")
    private DeviceType deviceType;
    
    @Size(max = 500, message = "Descrição deve ter no máximo 500 caracteres")
    private String description;
    
    @Size(max = 200, message = "Localização deve ter no máximo 200 caracteres")
    private String location;
    
    private Double latitude;
    
    private Double longitude;
    
    // Status será definido como INACTIVE por padrão na entidade
    // isActive será definido como true por padrão na entidade
}
