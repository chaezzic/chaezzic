package chaezzic.chaezzicspring.service;

import chaezzic.chaezzicspring.domain.selection.JobList;
import chaezzic.chaezzicspring.domain.selection.Part;
import chaezzic.chaezzicspring.domain.selection.Year;
import chaezzic.chaezzicspring.repository.JobSkillsRepository;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Data
public class JobSkillsService {
    private final JobSkillsRepository jobSkillsRepository;

    public JobSkillsService(JobSkillsRepository jobSkillsRepository){
        this.jobSkillsRepository = jobSkillsRepository;
    }

    Year year2023 = new Year("2023", "2023년");
    Year year2022 = new Year("2022", "2022년");

    Part firstHalf = new Part("상반기", "상반기");
    Part secondHalf = new Part("하반기", "하반기");


    JobList cLang = new JobList("C, Cpp 개발", "C/Cpp 개발");
    JobList dba = new JobList("DBA(Database Admin.)", "DBA(Database Admin.)");
    JobList devOps = new JobList("DevOps 개발", "DevOps 개발");
    JobList nodeJs = new JobList("Node.js 개발", "Node.js 개발");
    JobList php = new JobList("PHP 개발", "PHP 개발");
    JobList qa = new JobList("QA(Quality Assurance)", "QA(Quality Assurance)");
    JobList ios = new JobList("iOS 개발", "iOS 개발");
    JobList game = new JobList("게임개발", "게임개발");
    JobList etc = new JobList("네트워크, 클라우드, 보안, 운영", "네트워크/클라우드/보안/운영");
    JobList dataAns = new JobList("데이터 분석가", "데이터 분석가");
    JobList dataEng = new JobList("데이터 엔지니어", "데이터 엔지니어");
    JobList mlDev = new JobList("머신러닝 개발", "머신러닝 개발");
    JobList backend = new JobList("백엔드 개발", "백엔드 개발");
    JobList secEng = new JobList("보안 엔지니어", "보안 엔지니어");
    JobList blockchain = new JobList("블록체인 플랫폼 개발자", "블록체인 플랫폼 개발자");
    JobList bigData = new JobList("빅데이터 엔지니어", "빅데이터 엔지니어");
    JobList server = new JobList("서버 개발", "서버 개발");
    JobList software = new JobList("소프트웨어 개발", "소프트웨어 개발");
    JobList android = new JobList("안드로이드 개발", "안드로이드 개발");
    JobList embedded = new JobList("임베디드 개발", "임베디드 개발");
    JobList java = new JobList("자바 개발", "자바 개발");
    JobList crossPlatform = new JobList("크로스 플랫폼 개발", "크로스 플랫폼 개발");
    JobList python = new JobList("파이썬 개발", "파이썬 개발");
    JobList frontend = new JobList("프론트엔드 개발", "프론트엔드 개발");
    JobList hwDev = new JobList("하드웨어 개발", "하드웨어 개발");
    JobList hwEng = new JobList("하드웨어 엔지니어", "하드웨어 엔지니어");

}
