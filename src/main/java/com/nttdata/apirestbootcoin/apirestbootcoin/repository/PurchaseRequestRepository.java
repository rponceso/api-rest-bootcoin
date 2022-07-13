/**
 * Repository that stores Purchase information
 *
 * @author Renato Ponce
 * @version 1.0
 * @since 2022-06-24
 */

package com.nttdata.apirestbootcoin.apirestbootcoin.repository;

import com.nttdata.apirestbootcoin.apirestbootcoin.model.PurchaseRequest;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PurchaseRequestRepository extends ReactiveMongoRepository<PurchaseRequest, String> {


}
