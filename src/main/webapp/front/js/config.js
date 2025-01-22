
var projectName = '基于web的邮票鉴赏系统及实现';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
        name: '我的收藏',
        url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '邮票信息',
	url: './pages/youpiaoxinxi/list.html'
}, 
{
	name: '文章信息',
	url: './pages/wenzhangxinxi/list.html'
}, 
{
	name: '个人分享',
	url: './pages/gerenfenxiang/list.html'
}, 

]

var adminurl =  "http://localhost:8080/ssm34f5g/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除","报表","查看评论"],"menu":"邮票信息","menuJump":"列表","tableName":"youpiaoxinxi"}],"menu":"邮票信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"邮票分类","menuJump":"列表","tableName":"youpiaofenlei"}],"menu":"邮票分类管理"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["新增","查看","修改","删除","查看评论"],"menu":"文章信息","menuJump":"列表","tableName":"wenzhangxinxi"}],"menu":"文章信息管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看","删除","查看评论"],"menu":"个人分享","menuJump":"列表","tableName":"gerenfenxiang"}],"menu":"个人分享管理"},{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","查看评论"],"menu":"邮票信息列表","menuJump":"列表","tableName":"youpiaoxinxi"}],"menu":"邮票信息模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看","查看评论"],"menu":"文章信息列表","menuJump":"列表","tableName":"wenzhangxinxi"}],"menu":"文章信息模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看评论","查看"],"menu":"个人分享列表","menuJump":"列表","tableName":"gerenfenxiang"}],"menu":"个人分享模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除","查看评论"],"menu":"个人分享","menuJump":"列表","tableName":"gerenfenxiang"}],"menu":"个人分享管理"},{"child":[{"appFrontIcon":"cuIcon-favor","buttons":["查看","删除"],"menu":"我的收藏管理","tableName":"storeup"}],"menu":"我的收藏管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","查看评论"],"menu":"邮票信息列表","menuJump":"列表","tableName":"youpiaoxinxi"}],"menu":"邮票信息模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["查看","查看评论"],"menu":"文章信息列表","menuJump":"列表","tableName":"wenzhangxinxi"}],"menu":"文章信息模块"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看评论","查看"],"menu":"个人分享列表","menuJump":"列表","tableName":"gerenfenxiang"}],"menu":"个人分享模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
