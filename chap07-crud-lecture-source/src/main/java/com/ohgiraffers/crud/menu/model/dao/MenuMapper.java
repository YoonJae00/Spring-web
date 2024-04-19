package com.ohgiraffers.crud.menu.model.dao;

import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.ChatDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDTO> findAllMenu();


    List<CategoryDTO> findAllCategory();

    void registNewMenu(MenuDTO newMenu);

    void goMessage(String chat, int whoareyou);

    List<ChatDTO> allchatting();
}
