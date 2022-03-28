package uz.master.warehouse.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.master.warehouse.entity.payment.Payment;
import uz.master.warehouse.entity.products.InComeProducts;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InComeProductsRepository extends JpaRepository<InComeProducts, Long> {






    @Query(value = "SELECT e.* FROM in_come_products e WHERE DATE(e.created_at) >=?1 and DATE(e.created_at) <=?2", nativeQuery = true)
    List<InComeProducts> findAllByDateTimeDateBetween(LocalDate from, LocalDate to);


    List<InComeProducts> findAllByGroupProductsId(Long groupProductsId);
}
