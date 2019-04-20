/**
 * 
 */

package com.epam.repository;

import com.epam.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface CustomerRepository.
 *
 * @author Nitin_Hasija
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
