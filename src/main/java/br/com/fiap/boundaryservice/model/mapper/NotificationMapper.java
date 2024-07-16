package br.com.fiap.boundaryservice.model.mapper;

import br.com.fiap.boundaryservice.model.dto.NotificationDTO;
import br.com.fiap.boundaryservice.model.entity.Notification;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

  @Mapping(target = "send_channels", source = "sendChannel")
  @Mapping(target = "created_at", source = "createdAt")
  @Mapping(target = "updated_at", source = "updatedAt")
  NotificationDTO toDTO(Notification notification);

  @InheritInverseConfiguration
  Notification toEntity(NotificationDTO notificationDTO);

}
