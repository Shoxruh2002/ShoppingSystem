package uz.master.warehouse.dto.groupProducts;

import lombok.Getter;
import lombok.Setter;
import uz.master.warehouse.dto.GenericDto;

import java.time.LocalDateTime;

/**
 * @author Panjiyev Javohir, сб 14:52. 26.03.2022
 */
@Getter
@Setter
public class GroupProductsDto extends GenericDto {
    private Long companyId;

    private LocalDateTime date;
}
