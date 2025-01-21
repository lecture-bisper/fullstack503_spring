package bitc.fullstack503.board2.mapper;

import bitc.fullstack503.board2.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

//  사용자 존재 여부 확인
  int isUserInfo(@Param("userId") String userId, @Param("userPw") String userPw);

//  사용자 정보 가져오기
  UserDTO getUserInfo(@Param("userId") String userId);
}












