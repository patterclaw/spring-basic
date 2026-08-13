package hello.core.member;


import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> map = new HashMap<>();
    @Override
    public void save(Member member) {
        map.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return map.get(memberId);
    }
}
