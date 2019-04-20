/**
 * 
 */

package com.epam.repository;

import com.epam.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface AccountRepository.
 *
 * @author Nitin_Hasija
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}
