package team.ccnu.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.ccnu.project.domain.entity.MemberEntity;
import team.ccnu.project.domain.repository.MemberRepository;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void deleteUser(String id) {
        memberRepository.deleteById(id);
    }
    public MemberEntity findBySn(Long sn) {
        return memberRepository.findBySn(sn);
    }
    public MemberEntity addUser(String id, String pw, String name, String email) {
        MemberEntity member = new MemberEntity();
        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setEmail(email);
        return memberRepository.save(member);
    }

    public MemberEntity findByName(String name) {
        return memberRepository.findByName(name);
    }

    public MemberEntity findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public MemberEntity findById(String id) {
        return memberRepository.findById(id);
    }
}
