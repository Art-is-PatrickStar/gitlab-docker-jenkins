package com.wsw.wswserver.repository;

import com.wsw.wswserver.entity.Hr;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author WangSongWen
 * @Date: Created in 16:38 2020/9/11
 * @Description:
 */
public interface HrRepository extends JpaRepository<Hr, Integer> {
    Hr findHrByUsername(String username);
}
