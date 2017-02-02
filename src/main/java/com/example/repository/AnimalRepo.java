package com.example.repository;

import com.example.data.Animal;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jasonskipper on 2/2/17.
 */
public interface AnimalRepo extends CrudRepository<Animal, Long>{
}
