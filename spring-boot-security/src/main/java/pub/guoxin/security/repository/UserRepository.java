package pub.guoxin.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import pub.guoxin.security.model.User;

/**
 * Created by guoxin on 17-8-26.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>, QueryDslPredicateExecutor<User> {
    User findByUsername(String username);
}
