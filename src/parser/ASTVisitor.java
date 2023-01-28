package parser;

import ast.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends PCFBaseVisitor<AST> {

    @Override
    public AST visitLit(PCFParser.LitContext ctx) {
        return new Lit(Integer.parseInt(ctx.getText()));
    }

    @Override
    public AST visitBinOp(PCFParser.BinOpContext ctx) {
        OP op;
        if (ctx.OPHP()==null){
            op = OP.parseOP(ctx.OPLP().getText());
        } else {
            op = OP.parseOP(ctx.OPHP().getText());
        }
        List<PCFParser.TermContext> ANTLRTerms = ctx.term();
        List<Term> terms = new ArrayList<>();
        for (PCFParser.TermContext ANTLRTerm : ANTLRTerms)
            terms.add((Term) visit(ANTLRTerm));
        return new BinOp(op, terms.get(0), terms.get(1));
    }

    @Override
    public AST visitCond(PCFParser.CondContext ctx) {
        List<PCFParser.TermContext> ANTLRTerms = ctx.term();
        List<Term> terms = new ArrayList<>();
        for (PCFParser.TermContext ANTLRTerm : ANTLRTerms)
            terms.add((Term) visit(ANTLRTerm));
        return new Cond(terms.get(0), terms.get(1), terms.get(2));
    }

    @Override
    public AST visitPar(PCFParser.ParContext ctx) {
        PCFParser.TermContext ANTLRTerm = ctx.term();
        Term term = (Term) visit(ANTLRTerm);
        return term;
    }

    @Override
    public AST visitVar(PCFParser.VarContext ctx) {
        TerminalNode var = ctx.VAR();
        var.getText();
        return new Let(ctx.VAR().getText(),(Term) visit(ctx.term(0)), (Term) visit(ctx.term(1)));
    }

    @Override
    public AST visitVarUse(PCFParser.VarUseContext ctx){
        return new VarUse(ctx.VAR().getText());
    }

    @Override
    public AST visitFun(PCFParser.FunContext ctx) {
        return new Func(new VarUse(ctx.VAR().getText()), (Term) visit(ctx.term()));
    }

    @Override
    public AST visitApp(PCFParser.AppContext ctx){
        List<PCFParser.TermContext> ANTLRTerms = ctx.term();
        List<Term> terms = new ArrayList<>();
        for (PCFParser.TermContext ANTLRTerm : ANTLRTerms)
            terms.add((Term) visit(ANTLRTerm));
        return new App(terms.get(0),terms.get(1));
    }



}