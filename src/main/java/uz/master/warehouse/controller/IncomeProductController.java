package uz.master.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.master.warehouse.controller.base.AbstractController;
import uz.master.warehouse.criteria.GenericCriteria;
import uz.master.warehouse.dto.InComeProducts.InComeProductsCreateDto;
import uz.master.warehouse.dto.InComeProducts.InComeProductsDto;
import uz.master.warehouse.dto.InComeProducts.InComeProductsUpdateDto;
import uz.master.warehouse.dto.responce.DataDto;
import uz.master.warehouse.services.products.InComeProductsService;

import javax.validation.Valid;
import java.util.List;


@RestController
@ParameterObject
@RequestMapping("income/*")
@RequiredArgsConstructor
public class IncomeProductController extends AbstractController {

    private final InComeProductsService inComeProductsService;

    @PostMapping(PATH + "/create")
    public ResponseEntity<DataDto<Long>> create(@Valid @RequestBody InComeProductsCreateDto dto) {
        return new ResponseEntity<>(inComeProductsService.create(dto), HttpStatus.OK);
    }

    @GetMapping(PATH + "/list")
    public ResponseEntity<DataDto<List<InComeProductsDto>>> getAll() {
        return new ResponseEntity<>(inComeProductsService.getAll(), HttpStatus.OK);
    }

    @GetMapping(PATH + "/listCriteria")
    public ResponseEntity<DataDto<List<InComeProductsDto>>> getWithCriteria(GenericCriteria criteria) {
        return new ResponseEntity<>(inComeProductsService.getWithCriteria(criteria), HttpStatus.OK);
    }

    @GetMapping(PATH + "/get/{id}")
    public ResponseEntity<DataDto<InComeProductsDto>> get(@PathVariable Long id) {
        return new ResponseEntity<>(inComeProductsService.get(id), HttpStatus.OK);

    }


    @DeleteMapping(PATH + "/delete/{id}")
    public ResponseEntity<DataDto> delete(@PathVariable Long id) {
        inComeProductsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping(PATH + "/update")
    public ResponseEntity<DataDto<Long>> update(@Valid @RequestBody InComeProductsUpdateDto dto) {
        return new ResponseEntity<>(inComeProductsService.update(dto), HttpStatus.OK);
    }

    @GetMapping(PATH + "/getBYTime")
    public ResponseEntity<DataDto<List<InComeProductsDto>>> getByTime(String from, String to) {
        return new ResponseEntity<>(inComeProductsService.getByTime(from, to), HttpStatus.OK);
    }


}
