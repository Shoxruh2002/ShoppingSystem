package uz.master.warehouse.dto.clientBar;

import uz.master.warehouse.dto.BaseDto;
import uz.master.warehouse.dto.GenericDto;

public class ClientBarDto extends GenericDto {
    private Long orgId;

    private String clientName;

    private Double overAllPrice;

    private boolean paid;

    private boolean taken;
}
