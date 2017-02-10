var gulp = require('gulp');
var concat = require('gulp-concat');
var connect = require("gulp-connect");
var less = require("gulp-less");
var autoprefixer = require('gulp-autoprefixer');
var uglify = require('gulp-uglify');
var ext_replace = require('gulp-ext-replace');
var cssmin = require('gulp-cssmin');
var rename = require('gulp-rename');

// var root='/git/jh-shenshu-microservices/jh-shensu-web/mobile/src/';
//var path = '../../src/main/resources/static/mobile';
var path = '/git/jh-shenshu-microservices/jh-shensu-app-web/src/main/resources/static';

gulp.task('less', function() {
    gulp.src(['./src/less/*.less'])
        .pipe(less())
        .pipe(cssmin())
        .pipe(autoprefixer())
        .pipe(gulp.dest(path + '/css'));

    gulp.src(['./src/less/style.css'])
        .pipe(rename('main.css'))
        .pipe(cssmin())
        .pipe(gulp.dest(path + '/css'));

    return;
});

gulp.task('template', function() {
    gulp.src(['./src/template/*.html'])
        .pipe(gulp.dest(path + '/template'));
});

gulp.task('watch_template', function() {
    gulp.watch('./src/template/*.html', ['template']);
});

gulp.task('index', function() {
    gulp.src(['./src/*.html'])
        .pipe(gulp.dest(path + '/'));
});

gulp.task('watch_index', function() {
    gulp.watch('./src/*.html', ['index']);
});

gulp.task('img', function() {
    gulp.src(['./src/img/*'])
        .pipe(gulp.dest(path + '/img'));
});

gulp.task('watch_img', function() {
    gulp.watch('./src/img/*', ['img']);
});

gulp.task('copyJs', function() {


    gulp.src([
            'node_modules/jquery/jquery.js',
            'node_modules/art-template/dist/template.js',
            'node_modules/director/build/director.js'
        ])
        .pipe(uglify({
            'mangle': true, //类型：Boolean 默认：true 是否修改变量名
            'compress': true, //类型：Boolean 默认：true 是否完全压缩
            'preserveComments': 'license' //保有注释
        }))
        .pipe(rename({ suffix: '.min' }))
        .pipe(gulp.dest(path + '/js/'));


    gulp.src([
            './src/js/hashmap.js',
            'jsBridge.js'
        ])
        .pipe(concat({ path: 'jsBridge.js' }))
        .pipe(uglify({
            'mangle': true, //类型：Boolean 默认：true 是否修改变量名
            'compress': true, //类型：Boolean 默认：true 是否完全压缩
            'preserveComments': 'license' //保有注释
        }))
        .pipe(rename({ suffix: '.min' }))
        .pipe(gulp.dest(path + '/js/'));

    gulp.src([
            'helpers.js',
            './src/js/app.js'
        ])
        .pipe(concat({ path: 'app.js' }))
        .pipe(uglify({
            'mangle': true, //类型：Boolean 默认：true 是否修改变量名
            'compress': true, //类型：Boolean 默认：true 是否完全压缩
            'preserveComments': 'license' //保有注释
        }))
        .pipe(rename({ suffix: '.min' }))
        .pipe(gulp.dest(path + '/js/'));
});


gulp.task('watch_jsbridge', function() {
    gulp.watch(['jsBridge.js',
        'helpers.js',
        './src/js/app.js'
    ], ['jsbridge']);
});

gulp.task('watch_less', function() {
    gulp.watch('./src/less/app.less', ['less']);
});

gulp.task('server', function() {
    connect.server({
        root: './',
        livereload: true,
        port: '9000'
    });
});

gulp.task('deploy', ['copyJs', 'less', 'template', 'compile', 'watch_less', 'watch_ts']);
gulp.task("default", ['copyJs', 'less', 'template', 'img', 'index', 'watch_index', 'watch_template', 'watch_less', 'watch_jsbridge', 'watch_img']);
