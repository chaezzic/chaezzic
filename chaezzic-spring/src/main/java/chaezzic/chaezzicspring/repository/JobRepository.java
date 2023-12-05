package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.Job;

import java.util.List;
import java.util.Optional;

public interface JobRepository {

    List<Job> findAll();
}
