package cn.sticki.blog.controller;

import cn.sticki.blog.pojo.vo.RankHotVO;
import cn.sticki.blog.service.RankService;
import cn.sticki.common.result.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author durance
 * @version 1.0
 * @date 2022/10/5 14:12
 */
@Slf4j
@RestController
@RequestMapping("/blog/rank")
public class BlogRankController {

	@Resource
	private RankService rankService;

	/**
	 * 获取当日热度排行榜信息
	 */
	@GetMapping("/hot/today")
	public RestResult<List<RankHotVO>> getTodayHotRank() {
		List<RankHotVO> rankHotToday = rankService.getTodayHotRank();
		// 如果没有得到数据
		if (rankHotToday == null) {
			return RestResult.ok(null, "今日暂无排行榜信息");
		}
		return RestResult.ok(rankHotToday);
	}

	/**
	 * 获取七日内热度排行榜信息
	 */
	@GetMapping("/hot/week")
	public RestResult<List<RankHotVO>> getWeekHotRank() {
		List<RankHotVO> rankHotWeek = rankService.getWeekHotRank();
		// 如果没有得到数据
		if (rankHotWeek == null) {
			return RestResult.ok(null, "上周暂无排行榜信息");
		}
		return RestResult.ok(rankHotWeek);
	}

}
