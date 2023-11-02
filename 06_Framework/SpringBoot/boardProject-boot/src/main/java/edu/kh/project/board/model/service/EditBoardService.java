package edu.kh.project.board.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dto.Board;

public interface EditBoardService {

	/** 게시글 삭제
 	 * @param paramMap
	 * @return result
	 */
	int deleteBoard(Map<String, Integer> paramMap);

	/** 게시글 작성(삽입)
	 * @param board
	 * @param images
	 * @return boardNo(실패 시 0)
	 */
	int insertBoard(Board board, List<MultipartFile> images) throws IllegalStateException, IOException;

}
