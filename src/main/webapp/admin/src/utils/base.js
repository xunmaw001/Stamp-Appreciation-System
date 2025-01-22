const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm34f5g/",
            name: "ssm34f5g",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm34f5g/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于web的邮票鉴赏系统及实现"
        } 
    }
}
export default base
