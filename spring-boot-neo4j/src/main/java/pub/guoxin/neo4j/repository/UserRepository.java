package pub.guoxin.neo4j.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import pub.guoxin.neo4j.model.User;

/**
 * Created by guoxin on 17-8-13.
 */
@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
}
