package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.QUser;
import chaezzic.chaezzicspring.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom{
    private JPAQueryFactory jpaQueryFactory;

    public UserRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<User> findByUserId(Long id){
        QUser user = QUser.user;
        User foundUser = jpaQueryFactory
                .selectFrom(user)
                .where(user.id.eq(id))
                .fetchOne();

        return Optional.ofNullable(foundUser);
    }
}
