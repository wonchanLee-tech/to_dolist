import { API_BASE_URL } from "./api-config";

export function call (api, method, request){
    var options = {
        headers: new Headers({
            "Content-Type": "application/json",
        }),
        url: API_BASE_URL + api,
        method: method,
    };
    if (request){
        // GET method
        options.body = JSON.stringify(request);
    }
    return fetch(options.url, options)
       .then((response) => response.json().then((json) => {
           if(!response.ok){
               // response.ok가 true이면 정상 응답 아니면 에러 응답
               return Promise.reject(json);
           }
           return json;
       }));
}