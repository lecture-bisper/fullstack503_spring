package bitc.fullstack503.board2.service;

import bitc.fullstack503.board2.dto.UserDTO;

public interface UserService {

//  사용자 존재 여부 확인
  boolean isUserInfo(String userId, String userPw);

//  사용자 정보 가져오기
  UserDTO getUserInfo(String userId);
}












