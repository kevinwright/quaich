/*
 * Copyright (c) 2016 Brendan McAdams & Thomas Lockney
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package codes.bytes.quaich.api.http.routing

import codes.bytes.quaich.api.http.model.{LambdaContext, LambdaHTTPRequest, LambdaHTTPResponse}
import org.json4s.JsonAST.JString


trait HTTPHandler {
  protected val request: LambdaHTTPRequest
  protected val context: LambdaContext

  protected val routeBuilder =
    Map.newBuilder[String, () => LambdaHTTPResponse]

  lazy val routes = routeBuilder.result

  // TODO - Magnet pattern for response handling...
  def routeRequest(): LambdaHTTPResponse = {
    LambdaHTTPResponse(JString("OK"))
  }

}

// vim: set ts=2 sw=2 sts=2 et:
