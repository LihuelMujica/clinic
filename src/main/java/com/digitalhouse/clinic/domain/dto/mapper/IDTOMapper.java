package com.digitalhouse.clinic.domain.dto.mapper;

import java.util.List;

public interface IDTOMapper<C,D> {
    public D toDTO(C c);
    public List<D> toDTO(List<C> c);
    public C toEntity(D d);
    public List<C> toEntity(List<D> d);
}
