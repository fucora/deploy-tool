/**
 * Copyright © 2018 mason (mianshenglee@foxmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.mason.deploytool.operation.command;

import me.mason.deploytool.util.FileUtils;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.lang3.StringUtils;

/**
 * windows下命令行操作
 *
 * @author mason
 *
 */
public class WindowsCommandRunner extends CommandRunner {

	@Override
	public String execute(CommandLine cmd,String charsetName) {
		CommandLine newCmd = new CommandLine("cmd");
		newCmd.addArgument("/c");
		newCmd.addArguments(cmd.toStrings());
		//默认是gbk
		if(StringUtils.isBlank(charsetName)){
			charsetName = FileUtils.CHARSET_GBK;
		}
		return this.runCommand(newCmd.toStrings(), charsetName);
	}

}
