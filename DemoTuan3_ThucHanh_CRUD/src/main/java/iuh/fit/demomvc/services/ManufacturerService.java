package iuh.fit.demomvc.services;

import iuh.fit.demomvc.entities.Manufacturer;
import iuh.fit.demomvc.repositories.ManufacturerRepository;

import java.util.List;

public class ManufacturerService {
    private ManufacturerRepository manufacturerRepository;

    public ManufacturerService() {
        manufacturerRepository = new ManufacturerRepository();
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getManufacturerById(String id) {
        return manufacturerRepository.findManufacturerById(id);
    }

    public Boolean delete(String id) { return manufacturerRepository.delete(id); }

    public  Boolean update(String id,Manufacturer manufacturer) {return  manufacturerRepository.update(id,manufacturer);}

}
