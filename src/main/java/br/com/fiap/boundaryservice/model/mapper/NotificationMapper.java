package br.com.fiap.boundaryservice.model.mapper;

import br.com.fiap.boundaryservice.model.dto.NotificationDTO;
import br.com.fiap.boundaryservice.model.entity.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

  NotificationDTO toDTO(Notification notification);
  Notification toEntity(NotificationDTO notificationDTO);

}
