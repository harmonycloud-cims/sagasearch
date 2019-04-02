package sagaquery.repository;

import sagaquery.entity.TxeventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxEventRepository extends JpaRepository<TxeventEntity,Long> {

}
