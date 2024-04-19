package com.ohgiraffers.fileupload;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {

    private String originFileName;
    private String savedName;
    private String filePath;
    private String fileDescription;
}
