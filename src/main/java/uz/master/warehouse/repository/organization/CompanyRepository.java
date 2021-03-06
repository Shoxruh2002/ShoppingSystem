package uz.master.warehouse.repository.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.master.warehouse.entity.organization.Company;

import javax.transaction.Transactional;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long>{


    @Transactional
    @Modifying
    @Query(value = "update Company c set c.deleted = true where c.id = :companyId")
    void deleteCompany(@Param("companyId") Long id);


    @Transactional
    @Modifying
    @Query(value = "update Company set name=:name   where id=:id")
    void update(@Param(value = "id") Long id, @Param(value = "name") String name);

    List<Company> findAllByDeletedFalse();

    Company findByIdAndDeletedFalse(Long id);
}
