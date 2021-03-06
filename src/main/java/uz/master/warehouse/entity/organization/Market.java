package uz.master.warehouse.entity.organization;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import uz.master.warehouse.entity.base.Auditable;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "market",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "location"})})
public class Market extends Auditable {
    private String name;
    private Long ownerId;
    private Long organizationId;
    private String location;
    private String description;

}
