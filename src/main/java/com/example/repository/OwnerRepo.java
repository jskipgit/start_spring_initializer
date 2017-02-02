package com.example.repository;

import com.example.data.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jasonskipper on 2/2/17.
 */
public interface OwnerRepo extends CrudRepository<Owner, Long> {
}
