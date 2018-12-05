namespace java thrift.generated

typedef i16 short
typedef i32 int
typedef i64 long
typedef string String
typedef bool boolean

struct Persion{

    1:optional String name;
    2:optional int age;
    3:optional boolean married;

}

exception DataException{

    1:optional String message;
    2:optional String callstack;
    3:optional String date;

}

service PersionService{

    Persion getPersionByName(1:required String name) throws (1:DataException dataException);

    void savePersion(1:required Persion persion) throws (1:DataException dataException);
}