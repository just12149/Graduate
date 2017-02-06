(function (angular) {
    var serviceModule = angular.module("myNoteApp.service", []);
    serviceModule.service("myService", function ($http) {

        /**
         * @param param
         * @returns {*}获取分页数据
         */
        this.queryPageDatas = function (params) {
            return ajaxRequest(context + "/news/indexPageJson.do", params);
        }
        /**
         * @param params
         * @returns {*}修改
         */
        this.updateUser = function (params) {
            return ajaxRequest(context+ "/news/updateJson.do", params);

        }
        /**
         * @param params
         * @returns {*}删除
         */
        this.delnewsId = function (params) {
            //console.log(params);
            return ajaxRequest(context + "/news/delJson.do", params)
        }


        function ajaxRequest(url, params) {
            return $http.post(url, params)

        }
    });

})(angular)