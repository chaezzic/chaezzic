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
    public List<JobDTO> findTop5Skills(String jobTitle, String part, String year){
        QJob job = QJob.job;
        QJobSkills jobSkills = QJobSkills.jobSkills;
        QSkill skill = QSkill.skill;

        return jpaQueryFactory.select(Projections.constructor(JobDTO.class, job.jobTitle, skill.name, jobSkills.count()))
                .from(job)
                .join(jobSkills).on(job.id.eq(jobSkills.jobId))
                .join(skill).on(jobSkills.skillId.eq(skill.id))
                .where(job.jobTitle.eq(jobTitle),
                        job.year.eq(year),
                        job.part.eq(part),
                        skill.name.ne("NULL"))
                .groupBy(job.jobTitle, skill.name)
                .orderBy(jobSkills.count().desc())
                .limit(5)
                .fetch();
    }

    @Override
    public Long totalCount(String jobTitle, String part, String year) {
        QJob job = QJob.job;
        QJobSkills jobSkills = QJobSkills.jobSkills;
        QSkill skill = QSkill.skill;

        return jpaQueryFactory.select(jobSkills.count().sum())
                .from(job)
                .join(jobSkills).on(job.id.eq(jobSkills.jobId))
                .join(skill).on(jobSkills.skillId.eq(skill.id))
                .where(job.jobTitle.eq(jobTitle),
                        job.year.eq(year),
                        job.part.eq(part),
                        skill.name.ne("NULL"))
                .groupBy(job.jobTitle, skill.name)
                .orderBy(jobSkills.count().desc())
                .fetchFirst();
    }

    @Override
    public List<String> companyListByStack(String skillName) {
        QJob job = QJob.job;
        QJobSkills jobSkills = QJobSkills.jobSkills;
        QSkill skill = QSkill.skill;

        List<String> companyList = jpaQueryFactory.selectDistinct(job.company)
                .from(job)
                .join(jobSkills).on(job.id.eq(jobSkills.jobId))
                .join(skill).on(jobSkills.skillId.eq(skill.id))
                .where(skill.name.eq(skillName))
                .fetch();

        return companyList;


    }
}
