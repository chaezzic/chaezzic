package chaezzic.chaezzicspring.repository;

import chaezzic.chaezzicspring.domain.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class JobRepositoryCustomImpl implements JobRepositoryCustom{

    private JPAQueryFactory jpaQueryFactory;

    public JobRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<JobDTO> findTop5Skills(String jobTitle){
        QJob job = QJob.job;
        QJobSkills jobSkills = QJobSkills.jobSkills;
        QSkill skill = QSkill.skill;

        return jpaQueryFactory.select(Projections.constructor(JobDTO.class, job.jobTitle, skill.name, jobSkills.count()))
                .from(job)
                .join(jobSkills).on(job.id.eq(jobSkills.jobId))
                .join(skill).on(jobSkills.skillId.eq(skill.id))
                .where(job.jobTitle.eq(jobTitle))
                .groupBy(job.jobTitle, skill.name)
                .orderBy(jobSkills.count().desc())
                .limit(5)
                .fetch();
    }
}
