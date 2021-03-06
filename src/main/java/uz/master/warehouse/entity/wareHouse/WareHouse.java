package uz.master.warehouse.entity.wareHouse;

import lombok.Getter;
import lombok.Setter;
import uz.master.warehouse.entity.base.Auditable;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
public class WareHouse extends Auditable {

    private Long marketId;

    private String name;

    @Column(nullable = false, unique = true)
    private String location;

    private Date paidDate;

    private Long organizationId;

}
