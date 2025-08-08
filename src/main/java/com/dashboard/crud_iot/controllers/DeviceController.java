package com.dashboard.crud_iot.controllers;

import com.dashboard.crud_iot.dto.DeviceCreateDTO;
import com.dashboard.crud_iot.dto.DeviceResponseDTO;
import com.dashboard.crud_iot.dto.DeviceUpdateDTO;
import com.dashboard.crud_iot.enums.DeviceStatus;
import com.dashboard.crud_iot.enums.DeviceType;
import com.dashboard.crud_iot.services.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST para gerenciamento de dispositivos IoT.
 * Fornece endpoints para todas as operações CRUD e funcionalidades específicas.
 */
@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*") // Para permitir requisições do frontend Angular
public class DeviceController {

    private final DeviceService deviceService;

    /**
     * Cria um novo dispositivo IoT
     * 
     * @param createDTO Dados do dispositivo a ser criado
     * @return DeviceResponseDTO com os dados do dispositivo criado
     */
    @PostMapping
    public ResponseEntity<DeviceResponseDTO> createDevice(@Valid @RequestBody DeviceCreateDTO createDTO) {
        log.info("Recebida requisição para criar dispositivo: {}", createDTO.getDeviceName());
        try {
            DeviceResponseDTO device = deviceService.createDevice(createDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(device);
        } catch (IllegalArgumentException e) {
            log.error("Erro ao criar dispositivo: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Busca todos os dispositivos
     * 
     * @return Lista de todos os dispositivos
     */
    @GetMapping
    public ResponseEntity<List<DeviceResponseDTO>> getAllDevices() {
        log.info("Recebida requisição para buscar todos os dispositivos");
        List<DeviceResponseDTO> devices = deviceService.getAllDevices();
        return ResponseEntity.ok(devices);
    }

    /**
     * Busca um dispositivo por ID
     * 
     * @param id ID do dispositivo
     * @return DeviceResponseDTO ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponseDTO> getDeviceById(@PathVariable Long id) {
        log.info("Recebida requisição para buscar dispositivo por ID: {}", id);
        Optional<DeviceResponseDTO> device = deviceService.getDeviceById(id);
        return device.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Busca dispositivos por tipo
     * 
     * @param type Tipo do dispositivo
     * @return Lista de dispositivos do tipo especificado
     */
    @GetMapping("/type/{type}")
    public ResponseEntity<List<DeviceResponseDTO>> getDevicesByType(@PathVariable DeviceType type) {
        log.info("Recebida requisição para buscar dispositivos por tipo: {}", type);
        List<DeviceResponseDTO> devices = deviceService.getDevicesByType(type);
        return ResponseEntity.ok(devices);
    }

    /**
     * Busca dispositivos por status
     * 
     * @param status Status do dispositivo
     * @return Lista de dispositivos com o status especificado
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<DeviceResponseDTO>> getDevicesByStatus(@PathVariable DeviceStatus status) {
        log.info("Recebida requisição para buscar dispositivos por status: {}", status);
        List<DeviceResponseDTO> devices = deviceService.getDevicesByStatus(status);
        return ResponseEntity.ok(devices);
    }

    /**
     * Busca dispositivos online
     * 
     * @return Lista de dispositivos que se comunicaram nos últimos 5 minutos
     */
    @GetMapping("/online")
    public ResponseEntity<List<DeviceResponseDTO>> getOnlineDevices() {
        log.info("Recebida requisição para buscar dispositivos online");
        List<DeviceResponseDTO> devices = deviceService.getOnlineDevices();
        return ResponseEntity.ok(devices);
    }

    /**
     * Busca dispositivos offline
     * 
     * @return Lista de dispositivos que não se comunicam há mais de 5 minutos
     */
    @GetMapping("/offline")
    public ResponseEntity<List<DeviceResponseDTO>> getOfflineDevices() {
        log.info("Recebida requisição para buscar dispositivos offline");
        List<DeviceResponseDTO> devices = deviceService.getOfflineDevices();
        return ResponseEntity.ok(devices);
    }

    /**
     * Atualiza um dispositivo existente
     * 
     * @param id        ID do dispositivo a ser atualizado
     * @param updateDTO Dados para atualização
     * @return DeviceResponseDTO com os dados atualizados
     */
    @PutMapping("/{id}")
    public ResponseEntity<DeviceResponseDTO> updateDevice(
            @PathVariable Long id,
            @Valid @RequestBody DeviceUpdateDTO updateDTO) {
        log.info("Recebida requisição para atualizar dispositivo ID: {}", id);
        try {
            DeviceResponseDTO device = deviceService.updateDevice(id, updateDTO);
            return ResponseEntity.ok(device);
        } catch (IllegalArgumentException e) {
            log.error("Erro ao atualizar dispositivo: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remove um dispositivo
     * 
     * @param id ID do dispositivo a ser removido
     * @return 204 No Content se removido com sucesso
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        log.info("Recebida requisição para remover dispositivo ID: {}", id);
        try {
            deviceService.deleteDevice(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            log.error("Erro ao remover dispositivo: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Atualiza a última comunicação de um dispositivo
     * Endpoint específico para quando um dispositivo IoT envia dados
     * 
     * @param id      ID do dispositivo
     * @param reading Leitura/dados enviados pelo dispositivo (opcional)
     * @return DeviceResponseDTO com os dados atualizados
     */
    @PatchMapping("/{id}/communication")
    public ResponseEntity<DeviceResponseDTO> updateLastCommunication(
            @PathVariable Long id,
            @RequestParam(required = false) String reading) {
        log.info("Recebida requisição para atualizar comunicação do dispositivo ID: {}", id);
        try {
            DeviceResponseDTO device = deviceService.updateLastCommunication(id, reading);
            return ResponseEntity.ok(device);
        } catch (IllegalArgumentException e) {
            log.error("Erro ao atualizar comunicação: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint de health check para verificar se a API está funcionando
     * 
     * @return Mensagem de status
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("API de Dispositivos IoT está funcionando!");
    }
}
