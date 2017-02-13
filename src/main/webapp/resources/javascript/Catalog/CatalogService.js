(function (angular) {
    var serviceModule = angular.module("CatalogApp.service", []);
    serviceModule.service("myService", function ($http) {

        /**
         * @param param
         * @returns {*}获取分页数据
         */
        this.queryPageDatas = function (params) {
            return ajaxRequest(context + "/news/queryCatalog.do", params);
        }
        /**
         * @param params
         * @returns {*}修改
         */
        this.updateCatalog = function (params) {
            return ajaxRequest(context+ "/news/updateCatalog.do", params);

        }
        /**
         * @param params
         * @returns {*}删除
         */
        this.delCatalogId = function (params) {
            //console.log(params);
            return ajaxRequest(context + "/news/delCatalog.do", params)
        }


        function ajaxRequest(url, params) {
            return $http.post(url, params)

        }
    });

})(angular)