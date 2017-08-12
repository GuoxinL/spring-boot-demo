package pub.guoxin.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import pub.guoxin.mongo.model.User;

/**
 * Created by guoxin on 17-8-12.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>, QueryDslPredicateExecutor<User> {
}
