package kg.itschool.security.mapper;

public interface BaseMapper<ENTITY, DTO> {
    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
