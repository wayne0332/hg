package cn.hg.extend.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.jooq.tools.LoggerListener;
import org.jooq.tools.StopWatch;

/**
 * TODO 修改jooq的log生成
 */
public class LogbackMessageFilter extends Filter<ILoggingEvent> {
	@Override
	public FilterReply decide(ILoggingEvent event) {
		if (event.getLoggerName().contains(LoggerListener.class.getName())) {
			if (!event.getMessage().contains("with bind values")) {
				return FilterReply.DENY;
			}
		}
		if (event.getLoggerName().contains(StopWatch.class.getName())) {
			if (!event.getMessage().contains("Finishing")) {
				return FilterReply.DENY;
			}
		}
		return FilterReply.ACCEPT;
	}
}
