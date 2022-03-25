package uz.master.warehouse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.master.warehouse.dto.clientBar.ClientBarCreateDto;
import uz.master.warehouse.dto.clientBar.ClientBarDto;
import uz.master.warehouse.dto.responce.DataDto;
import uz.master.warehouse.services.clientBar.ClientBarService;

@RestController
@RequestMapping("client/*")
@RequiredArgsConstructor
public class ClientBarController {

    private final ClientBarService service;

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ResponseEntity<DataDto<Long>> create(@RequestBody ClientBarCreateDto dto){
        return new ResponseEntity<>(new DataDto<>(service.create(dto)), HttpStatus.OK);
    }
    @RequestMapping(value = "real",method = RequestMethod.POST)
    public ResponseEntity<DataDto<Long>> creates(@RequestBody ClientBarCreateDto dto){
        return new ResponseEntity<>(new DataDto<>(service.create(dto)), HttpStatus.OK);
    }

}
