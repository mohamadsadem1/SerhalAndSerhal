package com.example.SerhalAndSerhal.Brand;

import com.example.SerhalAndSerhal.Brand.DTO.BrandRequest;
import com.example.SerhalAndSerhal.Brand.DTO.BrandResponse;
import com.example.SerhalAndSerhal.Exceptions.BrandAlreadyExistException;
import lombok.AllArgsConstructor;
import com.example.SerhalAndSerhal.Exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandServiceIMPL implements BrandService {

    private final BrandRepository brandRepository;


    @Override
    public BrandRequest createBrand(BrandRequest brandRequest) {




        Optional< Brand> optionalBrand = brandRepository.findBrandByName(brandRequest.getName());
        if(optionalBrand.isPresent()){
            throw new BrandAlreadyExistException (" this brand already exists ");
        }

        //convert the request to brand class to be added
        Brand brand = Brand.builder()
                .name(brandRequest.getName())
                .build();

        //save the brand converted
        Brand savedBrand = brandRepository.save(brand);

        //convert the brand to request to be
        BrandRequest savedBrandRequest = BrandRequest.builder().name(savedBrand.getName()).build();

        return savedBrandRequest;

    }

    @Override
    public BrandResponse updateBrandById(Long id, BrandRequest brandRequest) {

        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if(!optionalBrand.isPresent()){
            throw new ResourceNotFoundException("brand ",id.toString(),"value");
        }
        Brand brand = optionalBrand.get();
        brand.setName(brandRequest.getName());
        Brand savedBrand = brandRepository.save(brand);

        //convert the brand to request to be
        BrandResponse savedBrandRequest = BrandResponse
                .builder()
                .name(savedBrand.getName())
                .id(savedBrand.getId())
                .timeCreated(savedBrand.localTimeCreatedToString())
                .timeUpdated(savedBrand.localTimeUpdatedToString())
                .build();

        return savedBrandRequest;
    }


    @Override
    public void deleteBrandById(Long id) {

//        Brand existingBrand = brandRepository.findById(id)

        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if(!optionalBrand.isPresent()){
            throw new ResourceNotFoundException("brand ",id.toString(),"value");
        }
        Brand brand= optionalBrand.get();

        brandRepository.delete(brand);
    }

    @Override
    public BrandResponse getBrandById(Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("brand ",id.toString(),"brand"));
        return BrandResponse.builder()
                .name(brand.getName())
                .timeCreated(brand.localTimeCreatedToString())
                .timeUpdated(brand.localTimeUpdatedToString())
                .id(brand.getId())

                .build();

    }

    @Override
    public BrandResponse getBrandByName(String name) {
        Optional<Brand> brand = brandRepository.findBrandByName(name);
        if(brand.isPresent()){

        return BrandResponse.builder()
                .id(brand.get().getId())
                .name(brand.get().getName())
                .timeCreated(brand.get().localTimeCreatedToString())
                .timeUpdated(brand.get().localTimeUpdatedToString())
                .build();}
        else    throw  new ResourceNotFoundException("brand ",name,"dd");
    }




    @Override
    public List<BrandResponse> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream()
                .map(brand -> BrandResponse.builder()
                        .name(brand.getName())
                        .timeCreated(brand.localTimeCreatedToString())
                        .timeUpdated(brand.localTimeUpdatedToString())
                        .id(brand.getId())
                        .build())
                .collect(Collectors.toList());

    }
}
