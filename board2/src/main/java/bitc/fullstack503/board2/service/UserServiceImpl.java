package bitc.fullstack503.board2.service;

import bitc.fullstack503.board2.dto.UserDTO;
import bitc.fullstack503.board2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

//  사용자 존재 여부 확인 구현
  @Override
  public boolean isUserInfo(String userId, String userPw) {

//    userMapper 에서 제공하는 isUserInfo() 메소드를 사용하여 사용자 존재 여부를 확인
    int result = userMapper.isUserInfo(userId, userPw);

    if (result == 1) {
//      사용자가 있을 경우 true 리턴
      return true;
    }
    else {
//      사용자가 없을 경우 false 리턴
      return false;
    }
  }

//  사용자 정보 가져오기 구현
  @Override
  public UserDTO getUserInfo(String userId) {
//    userMapper 에서 제공하는 getUserInfo() 메소드를 사용하여 지정한 사용자의 정보를 가져옴
    return userMapper.getUserInfo(userId);
  }
}












